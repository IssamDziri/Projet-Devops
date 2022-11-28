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
	    
    
                     }
        stage('MVN COMPILE') {
            steps {
               sh 'mvn compile'
            
           }
		stage('MVN JUNIT') {
            steps {
                echo ''
                   }
                        }
        
	stage ('SONAR'){
            steps {
        
                  sh "mvn sonar:sonar \
  -Dsonar.projectKey=dev \
  -Dsonar.host.url=http://192.168.1.11:9000 \
  -Dsonar.login=27c7596cef5c4797dd38b8930699fac8aca59e9b"

                 }
         stage('BUILD'){
            steps{
                sh 'mvn install package'
            }
         }
        
                     
        stage('NEXUS') {
     
             steps {
             sh 'mvn deploy -DskipTests'
                    }
                       }
    
    
       stage('DOCKER BUILD') {

			steps {
				sh 'docker build -t 99266565/achat .'
			}
		}
			stage('DOCKER LOGIN') {

			steps { 
			    sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR -p $DOCKERHUB_CREDENTIALS_PSW'
			}
		} 
	    
	    	stage('DOCKER PUSH') {

			steps {
				sh 'docker push 99266565/achat'
			}
		}
		
	    
		 stage('DOCKER-COMPOSE'){
          
			 	steps{
             
					script{
                				    sh 'docker-compose up -d'
                		   	      }
         			      }
		 }
       
        
		
	}		    
    
    post {
                success {
                     mail to: "amine.m'sallem@esprit.tn",
                     subject: "success",
                     body: "success on job ${env.JOB_NAME}, Build Number: ${env.BUILD_NUMBER}, Build URL: ${env.BUILD_URL}"
               		 }
		failure {
                    mail to: "amine.m'sallem@esprit.tn",
                     subject: "Failure",
                     body: "Failure on job ${env.JOB_NAME}, Build Number: ${env.BUILD_NUMBER}, Build URL: ${env.BUILD_URL} "     
                	}
          
          }
}
	

