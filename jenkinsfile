pipeline {
  agent any 
  tools {
    maven 'M2_Home'
    jdk 'JAVA-HOME'
  }
  stages {
 
    stage("Mvn clean") {
      
      steps {
        echo 'cleaning the application ...'
        sh "mvn clean"
      }
    }
    stage("Mvn compile") {
      
      steps {
        echo 'compiling the application ...'
        sh "mvn compiler:compile"
      }
    }
      stage("test statique sonar") {
      
        steps { sh "mvn sonar:sonar \
           -Dsonar.projectKey=Issam \
           -Dsonar.host.url=http://192.168.1.16:9000 \
            -Dsonar.login=fd5cab5f77ad3fa468feda76eca29976331132b9"

    }
        }
            }
}
