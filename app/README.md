# Android Drills in Kotlin

This repository holds sample apps for Android in Kotlin.  
Each sample app is located as an independently runnable module under app directory.

### app/TakePhoto
Take a photo using AndroidX Activity Result API i.e.  
- call registerForActivityResult() with ActivityResultContracts.TakePicture() contract  
- launch the camera with returned ActivityResultLauncher's launch() method  
- take a shot with camera  
- Once returned from camera app shot taken is displayed on imageview.  

Created this sample app as wasn't able to find one when porting deprecated  
startActivityForResult() / onActivityResult() way of doing this in one of my apps.  
This one makes use of the current registerForActivityResult() way.  
Recent Maintenance by Android Android Studio Electric Eel | 2022.1.1