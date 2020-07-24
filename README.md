# App-to-App-Communication
Here you can send or receive data from one single app to another single  app through Intent. We can call App name and call package name and add one flag for it . In this process we can jump to the another app and also pass the data through bundle.

When user click on Go to Main App button at that time we call Intent 
Intent sendIntent = new Intent();
sendIntent.setClassName("com.pallab.mainapp", "com.pallab.mainapp.MainActivity");
sendIntent.setAction(Intent.ACTION_SEND);
sendIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
startActivity(sendIntent);

Through this package name and class name we can open any app installed in particular android device. Intent.ACTION_SEND able to open that particular app. Through the flag(FLAG_ACTIVITY_NEW_TASK) we  start new activity.

Main App will be open user will UI as give here. First Name, Middle Name & Last Name field will
 be blank. When user enter their full name.

When all operations will be over at that time user click on Done button at that 
time  android call our Receiver Android App through Intent  bundle pass all the data .
 like this:-

sendIntent.setClassName("com.madcap.receiverapp", 
"com.madcap.receiverapp.MainActivity");
sendIntent.setAction(Intent.ACTION_SEND);
sendIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
Intent.putExtra("first_name", first_name);
Intent.putExtra("middle_name", middle_name);
Intent.putExtra("last_name", middle_name);
