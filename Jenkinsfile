pipeline {
    agent any

    maven 3.2.5

    tools {
        git 'Default'
    }

    stages {
        stage('GetProject') {
            steps {
                git branch: 'main', url: 'https://github.com/dalyc117/TestRepo.git'
            }
        }
        stage('Build') {
            steps {
                sh "mvn clean:clean"

                sh "mvn dependency:copy-dependencies"

                sh "mvn compiler:compile"
            }
        }

        stage('Test') {
            steps {
                sh "mvn surefire:test"
            }
        }

        stage('Package'){
            steps {
                sh 'mvn package'
            }
        }

        stage('Archive'){
            steps {
                archiveArtifacts allowEmptyArchive: true,
                    artifacts:'**/VFC*.war'
            }
        }

        stage('Deploy'){
            steps {
                echo "Initiating Deployment"
                sh 'docker build -f Dockerfile -t vfc . '
            }
        }
    }
}
