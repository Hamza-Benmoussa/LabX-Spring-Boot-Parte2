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
                  bat 'mvn test -Dtest=AnalyseServiceImplTest'
                  bat 'mvn test -Dtest=EchantillonServiceImplTest'
                  bat 'mvn test -Dtest=UtilisateurServiceImplTest'
                  bat 'mvn test -Dtest=NormeServiceImplTest'
                  bat 'mvn test -Dtest=ReactifServiceTest'
                  bat 'mvn test -Dtest=PatientServiceImpTest'

              }
        }
        stage('Test Controller'){
                      steps{
                         bat 'mvn test -Dtest=AnalyseControllerTest'
                          bat 'mvn test -Dtest=ReactifControllerTest'
                          bat 'mvn test -Dtest=NormeControlerTest'
//                           bat 'mvn test -Dtest=PatientControlersTest'
//                           bat 'mvn test -Dtest=UtilisateurControlerTest'
                         bat 'mvn test -Dtest=EchantillonControllerTest'
                      }
        }
  }
}
