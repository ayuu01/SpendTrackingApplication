pipeline {
    agent any
    

    stages {
        stage('clean and install') {
            steps {
               bat 'mvn clean install'
            }
        }
        stage('Package') {
            steps {
               bat 'mvn package'
            }
        }
    }
}
