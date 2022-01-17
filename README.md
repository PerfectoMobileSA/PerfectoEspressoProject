# Espresso + Perfecto execution steps:

To build the apks & activate the plugin - Open a command-line/terminal window in the project's folder and run the following tasks in gradle:</br></br>
`cd PerfectoEspresso`</br>
`./gradlew assembleDebug assembleAndroidTest perfecto-android-inst -PconfigFileLocation=configFile.json -PcloudURL=${url} -PsecurityToken=${securityToken}`</br>

### Note: 
1. Replace ${url} with your perfecto cloud url. E.g.: demo.perfectomobile.com </br>
2. Replace ${securityToken} with your perfecto security token.</br>