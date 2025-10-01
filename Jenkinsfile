pipeline {
  agent any

  tools {
    jdk 'JDK17'      // نفس الاسم الذي عرّفته في Tools
    maven 'M3'       // نفس الاسم الذي عرّفته في Tools
  }

  options {
    timestamps()
    ansiColor('xterm')
    buildDiscarder(logRotator(numToKeepStr: '20'))
  }

  environment {
    ALLURE_COMMANDLINE = 'allure29'   // نفس اسم أداة Allure في Tools
    TESTNG_SUITE = 'testng.xml'       // موجود عندك في جذر الريبو
    MAVEN_OPTS = '-Dmaven.test.failure.ignore=true'
  }

  stages {
    stage('Checkout') {
      steps {
        checkout scm
        sh 'rm -rf target || true'
      }
    }

    stage('Build & Test') {
      steps {
        // نشغّل TestNG عبر Surefire باستخدام ملف السويت
        sh 'mvn -B -U clean test -Dsurefire.printSummary=true -DsuiteXmlFile=${TESTNG_SUITE}'
      }
    }

    stage('Archive Results') {
      steps {
        // خزّن التقارير الخام لمرجعتها لاحقاً
        archiveArtifacts artifacts: 'target/surefire-reports/**/*, allure-results/**/*', fingerprint: true, onlyIfSuccessful: false
        // قراءة نتائج TestNG كـ JUnit في Jenkins
        junit allowEmptyResults: true, testResults: 'target/surefire-reports/*.xml'
      }
    }

    stage('Publish Allure Report') {
      steps {
        // نشر تقرير Allure من المجلد الجذري allure-results/
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
