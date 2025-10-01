pipeline {
  agent any

  tools {
    jdk 'JDK17'    // نفس الاسم المعرّف في Manage Jenkins > Tools
    maven 'M3'     // نفس الاسم المعرّف في Tools
  }

  options {
    timestamps()
    ansiColor('xterm')
    buildDiscarder(logRotator(numToKeepStr: '20'))
  }

  environment {
    ALLURE_COMMANDLINE = 'allure29'   // اسم أداة Allure في Tools (لو مستخدم خطوة allure أدناه)
    TESTNG_SUITE = 'testng.xml'
    MAVEN_OPTS = '-Dmaven.test.failure.ignore=true'
  }

  stages {
    stage('Checkout') {
      steps {
        checkout scm
        // حذف target بأسلوب Windows
        bat 'if exist target rmdir /S /Q target'
      }
    }

    stage('Build & Test') {
      steps {
        // تشغيل Maven على Windows
        bat 'mvn -v'
        bat 'mvn -B -U clean test -Dsurefire.printSummary=true -DsuiteXmlFile=%TESTNG_SUITE%'
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
        // يتطلب Allure Jenkins Plugin + Tool باسم ALLURE_COMMANDLINE
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
