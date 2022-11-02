pipeline {
  agent any
  stages {
    stage('clean') {
      agent any
      steps {
        sh 'sh mvn clean'
      }
    }

    stage('test') {
      steps {
        sh 'sh \'mvn test\''
      }
    }

    stage('package') {
      steps {
        sh 'sh \'mvn package\''
      }
    }

  }
}