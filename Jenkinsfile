pipeline {
  agent any

  tools {
    jdk 'JDK17'
    maven 'M3'
  }

  environment {
    ALLURE_COMMANDLINE = 'allure29'
    TESTNG_SUITE = 'testng.xml'
  }

  stages {
    stage('Checkout') {
      steps {
        checkout scm
      }
    }
    stage('Build & Test') {
      steps {
        sh 'mvn clean test -DsuiteXmlFile=${TESTNG_SUITE}'
      }
    }
    stage('Publish Results') {
      steps {
        junit 'target/surefire-reports/*.xml'
        allure([
          results: [[path: 'target/allure-results']]
        ])
      }
    }
  }
}
