pipeline{
  agent any
tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "Maven"
    }

  stages{
        stage('Build'){
            steps{
                bat 'mvn -Dmaven.test.skip=true clean install'
            }
        }
        stage('Test Service'){
              steps{
                  bat 'mvn test -Dtest=AnalyseServiceTest'
                  bat 'mvn test -Dtest=EchantillonServiceTest'
                  bat 'mvn test -Dtest=NumerationServiceTest'
                  bat 'mvn test -Dtest=PatientServiceTest'
                  bat 'mvn test -Dtest=NormeServiceTest'
                  bat 'mvn test -Dtest=ReactifServiceTest'
              }
        }
        stage('Test Controller'){
                      steps{
                          bat 'mvn test -Dtest=AnalyseControllerTest'
                          bat 'mvn test -Dtest=NumerationControllerTest'
                          bat 'mvn test -Dtest=ReactifControllerTest'
                          bat 'mvn test -Dtest=NormeControlersTest'
                          bat 'mvn test -Dtest=PatientControlersTest'
                          bat 'mvn test -Dtest=UtilisateurControlersTest'
                          bat 'mvn test -Dtest=EchantillonControllersTest'
                      }
        }
  }
}
