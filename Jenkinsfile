pipeline {
    agent any
    tools {
        maven 'maven3'
    }

    environment {
        IMAGE_NAME = 'imagecreatedbypiple'
        TAG_NAME = 'latest'
    }

    stages {
        stage('build') {
            steps {
                bat 'mvn clean package'
            }
        }

        stage('building docker image') {
            steps {
                bat 'docker build -t %IMAGE_NAME%:%TAG_NAME% .'
            }
        }

        stage('create the container of the image') {
            steps {
                bat 'docker run -d --name container_runing_usinJenkens %IMAGE_NAME%:%TAG_NAME%'
            }
        }
    }
}
