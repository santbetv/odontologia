pipeline {

  agent {
    label 'Slave_Induccion'
  }

  options {
    buildDiscarder(logRotator(numToKeepStr: '3'))
 	 disableConcurrentBuilds()
  }

  tools {
    jdk 'JDK8_Centos' //Preinstalada en la Configuración del Master
  }

  stages{
    stage('Checkout') {
      steps{
        echo "------------>Checkout<------------"
        checkout([
			$class: 'GitSCM',
			branches: [[name: '*/master']],
			doGenerateSubmoduleConfigurations: false,
			extensions: [],
			gitTool: 'Default',
			submoduleCfg: [],
			userRemoteConfigs: [[
				credentialsId: 'GitHub_santbetv',
				url:'https://github.com/santbetv/odontologia.git'
			]]
		])
      }
    }



    stage('Clean') {
      steps{
        echo "------------>Clean<------------"
        sh 'chmod +x ./microservicio/gradlew'
        sh './microservicio/gradlew --b ./microservicio/build.gradle clean'

      }
    }

    stage('Unit Tests') {
      steps{
        
	echo "------------>Compile project<------------"
        sh './microservicio/gradlew --b ./microservicio/build.gradle compileJava'
        
	echo "------------>Unit Tests<------------"
        sh './microservicio/gradlew --b ./microservicio/build.gradle clean'
	sh './gradlew --b ./microservicio/build.gradle test'
        sh './microservicio/gradlew --b ./microservicio/build.gradle jacocoTestReport' 
      }
    }

    stage('Static Code Analysis') {
      steps{
          echo '------------>Análisis de código estático<------------'

		withSonarQubeEnv('Sonar') {
                  sh "${tool name: 'SonarScanner', type:'hudson.plugins.sonar.SonarRunnerInstallation'}/bin/sonar-scanner -Dproject.settings=sonar-project.properties" 
                }
	    }     
       
    }

    stage('Build') {
      steps {
        echo "------------>Build<------------"
	    sh './microservicio/gradlew --b ./microservicio/build.gradle build -x test'
      }
    }
  }

  post {
    always {
      echo 'This will always run'
    }
    success {
      echo 'This will run only if successful'
    }
    failure {
      echo 'This will run only if failed'
      mail (to: 'santiago.betancur@ceiba.com.co',subject: "Failed Pipeline:${currentBuild.fullDisplayName}",body: "Something is wrong with ${env.BUILD_URL}")
    }
	unstable {
      echo 'This will run only if the run was marked as unstable'
    }
    changed {
      echo 'This will run only if the state of the Pipeline has changed'
      echo 'For example, if the Pipeline was previously failing but is now successful'
    }
  }
}