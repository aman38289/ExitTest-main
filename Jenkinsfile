pipeline {
    agent any

    tools {
        maven 'MAVEN_default' // Ensure this matches the Maven version on your Jenkins server
        jdk 'JAVA_default' // Ensure this matches the JDK version on your Jenkins server
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        
        stage('Build') {
            steps {
                bat 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }
    }
    post {
        always {
            cleanWs()
        }
        success {
            echo 'Build and deploy successful!'
        }
        failure {
            echo 'Build failed!'
        }
    }
}
