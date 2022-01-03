from PIL import Image
import os
import numpy as np

import tensorflow as tf

data_dir="./images/"
files=os.listdir(data_dir)
images=[]
for file in files:
    path=os.path.join(data_dir,file)
    images.append(np.array(Image.open(path)))
    print(images)

resized_images=np.array(np.zeros((len(images),224,224,3)))
for i in range(len(images)):
    resized_images[i]=tf.image.resize(images[i],[224,224])
preprocessed_images=tf.keras.applications.mobilenet_v2.preprocess_input(resized_images)

mobilenet_imagenet_model=tf.keras.applications.MobileNetV2(weights="imagenet")

y_pred=mobilenet_imagenet_model.predict(preprocessed_images)
topK=1
y_pred_top=tf.keras.applications.mobilenet_v2.decode_predictions(y_pred,top=topK)

from matplotlib import pyplot as plt
for i in range(len(images)):
    for k in range(topK):
        print(f'{y_pred_top[i][k][1]}')

mlp_model = tf.keras.Sequential([
    tf.keras.layers.Flatten(input_shape=(28, 28)),
    tf.keras.layers.Dense(128, activation='relu'),
    tf.keras.layers.Dense(10, activation='softmax'),
])
#not tflite
tf.saved_model.save(mlp_model,"./mlp_model/")

#tflite
converter=tf.lite.TFLiteConverter.from_saved_model("./mlp_model/")
tflite_model=converter.convert()
with open('./saved_model.tflite','wb') as f:
    f.write(tflite_model)