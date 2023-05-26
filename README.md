# Espresso + Perfecto execution steps:

- Clone this project and unzip it. 

- Open a command-line/terminal window, navigate to the project's folder and run the following tasks in gradle to build the apk files:</br></br>
`cd PerfectoEspresso`</br>
`./gradlew assembleDebug assembleAndroidTest` </br></br>

- Run the below gradle task to run Espresso tests on real devices:</br></br>
`./gradlew perfecto-android-inst -PconfigFileLocation=configFile.json -PcloudURL=${url} -PsecurityToken=${securityToken}`</br></br>

- Run the below gradle task to run Espresso tests on virtual devices:</br></br>
`./gradlew perfecto-android-inst-vd -PconfigFileLocation=configFile.json -PcloudURL=${url} -PsecurityToken=${securityToken}`</br>

### Note: 
1. Replace ${url} with your perfecto cloud url. E.g.: demo.perfectomobile.com (without the .app notation)</br>
2. Replace ${securityToken} with your [perfecto security token](https://help.perfecto.io/perfecto-help/content/perfecto/automation-testing/generate_security_tokens.htm?Highlight=Generate%20security%20tokens).</br>