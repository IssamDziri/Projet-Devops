pipeline {
    agent any
    environment{
        DOCKERHUB_CREDENTIALS=credentials('2092728d-9394-439d-b2e7-38de4228a9e5')
        PATH = "$PATH:/usr/share/maven/bin"
       
    }
   

    stages {
        stage('GIT') {
          
         steps {
                echo 'cloning project from GIT'
                git branch : "amine" , 
                url :'https://github.com/IssamDziri/Projet-Devops.git'
            }
            
        }
         
        stage('MVN CLEAN') {
            steps {
               sh 'mvn clean'
            }
        }
        stage('MVN COMPILE') {
            steps {
               sh 'mvn compile'
            
           }
        }
         stage('build'){
            steps{
                sh 'mvn install package'
            }
         }
        stage ('SONAR'){
            steps {
        //
                  sh "mvn sonar:sonar \
                        -Dsonar.projectKey=devops \
                        -Dsonar.host.url=http://192.168.1.29:9000 \
                        -Dsonar.login=01fc7fe679be32f2849631e11b9ddd91e741918a"

                 }
    
                     }
                     
        stage('NEXUS') {
     
             steps {
             sh 'mvn deploy -DskipTests'
                    }
                       }
    
    
       stage('Docker Build') {

			steps {
				sh 'docker build -t 99266565/achat .'
			}
		}
			stage('Docker Login') {

			steps { 
			    sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR -p $DOCKERHUB_CREDENTIALS_PSW'
			}
		} 
		
		      stage('Docker Compose'){
            steps{
                script{
                    sh 'docker-compose up -d'
                }
            }
       
        }
			stage('Dcker Push') {

			steps {
				sh 'docker push 99266565/achat'
			}
		}
    }
        
}
