pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                bat 'git checkout fatimaz' 
            }
        }

        stage('Test Connection') {
            steps {
                echo 'successfully connected '
            }
        }
    }

    post {
        success {
            echo 'Pipeline executed successfully!'
        }
        failure {
            echo 'Pipeline failed! Check the logs for details.'
        }
    }
}
