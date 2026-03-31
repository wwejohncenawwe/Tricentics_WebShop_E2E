pipeline {
    agent any

    tools {
        maven 'Maven'   // configure in Jenkins tools
        jdk 'Java'      // configure JDK
    }

    stages {

        stage('Clone') {
            steps {
                git 'https://github.com/wwejohncenawwe/Tricentics_WebShop_E2E.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Package') {
            steps {
                bat 'mvn package'
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploy step here'
                // Example: copy jar to server
            }
        }
    }
}