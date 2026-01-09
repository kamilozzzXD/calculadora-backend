pipeline {
    agent any

    environment {
        IMAGE_NAME = "calculadora-backend"
        CONTAINER_NAME = "calculadora-backend"
    }

    stages {

        stage('Checkout') {
            steps {
                echo '📥 Clonando repositorio backend'
                checkout scm
            }
        }

        stage('Build JAR') {
            steps {
                echo '⚙️ Compilando backend con Maven'
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Build Docker Image') {
            steps {
                echo '🐳 Construyendo imagen Docker'
                sh "docker build -t ${IMAGE_NAME} ."
            }
        }

        stage('Deploy Backend') {
            steps {
                echo '🚀 Desplegando backend'
                sh '''
                docker compose down
                docker compose up -d
                '''
            }
        }
    }

    post {
        success {
            echo '✅ Backend desplegado correctamente'
        }
        failure {
            echo '❌ Error en el pipeline del backend'
        }
    }
}
