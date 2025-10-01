pipeline {
  agent any

  tools {
    jdk 'JDK17'
    maven 'M3'
  }

  options {
    timestamps()
    ansiColor('xterm')
    buildDiscarder(logRotator(numToKeepStr: '20'))
  }

  environment {
    ALLURE_COMMANDLINE = 'allure29'
    TESTNG_SUITE = 'testng.xml'
    MAVEN_OPTS = '-Dmaven.test.failure.ignore=true'
  }

  stages {
    stage('Checkout') {
      steps {
        checkout scm
        // تنظيف مجلد target على ويندوز
        bat 'if exist target rmdir /S /Q target'
      }
    }

    stage('Build & Test') {
      steps {
        ansiColor('xterm') {
          // تشغيل Maven عبر bat، واستخدام %TESTNG_SUITE%
          bat 'mvn -B -U clean test -Dsurefire.printSummary=true -DsuiteXmlFile=%TESTNG_SUITE%'
        }
      }
    }

    stage('Archive Results') {
      steps {
        archiveArtifacts artifacts: 'target/surefire-reports/**/*, allure-results/**/*', fingerprint: true, onlyIfSuccessful: false
        junit allowEmptyResults: true, testResults: 'target/surefire-reports/*.xml'
      }
    }

    stage('Publish Allure Report') {
      steps {
        // نفس مسار النتائج اللي عندك في جذر الريبو
        allure([
          includeProperties: false,
          jdk: '',
          properties: [],
          reportBuildPolicy: 'ALWAYS',
          results: [[path: 'allure-results']]
        ])
      }
    }
  }

  post {
    always {
      echo "Build finished with status: ${currentBuild.currentResult}"
    }
  }
}
