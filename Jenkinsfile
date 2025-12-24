pipeline {
    agent any
        tools {
        maven 'maven3'
    }
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/tushartiwaskar1997/urlShotner.git'
            }
        }
        stage('build') {
            steps {
                bat 'mvn clean package'
            }
        }
        stage('test') {
            steps {
                bat 'mvn test'
            }
        }
    }
}
