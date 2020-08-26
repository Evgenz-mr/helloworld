pipeline {
    agent any

    parameters {
            string(name: 'BRANCH_NAME', defaultValue: "master")
            string(name: 'GIT_URL', defaultValue: "https://github.com/Evgenz-mr/helloworld.git")
            string(name: 'DOCKER_IMAGE', defaultValue: "")
            string(name: 'DOCKER_TAG', defaultValue: "")
            string(name: 'CRED_GIT', defaultValue: "github")
        }

    stages {
        stage('Pull code github') {
            steps {
                git branch: '$BRANCH_NAME',
                git credentialsId: '$GIT_URL',
                url: '$GIT_URL'
            }
        }

        stage('Build') {
            steps {
                withMaven(maven: 'Maven 3.6.0') {
                   sh "mvn clean package"
                   }
                }
            }

        stage('Create docker image') {
             steps {
                sh "docker build -t $DOCKER_IMAGE:$DOCKER_TAG ."
             }
        }

        stage('docker start') {
             steps {
                sh "docker run $DOCKER_IMAGE:$DOCKER_TAG"
             }
        }
    }
}