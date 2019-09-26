#!groovy
pipeline {
    agent any

    environment {
        NEXUS_VERSION = "nexus3"
        NEXUS_PROTOCOL = "http"
        NEXUS_URL = "my-nexus:8081"
        NEXUS_REPOSITORY = "maven-snapshots"
        NEXUS_CREDENTIAL_ID = "nexus-credentials"
    }

    stages {
        stage('Test') {
            steps {
                sh 'mvn clean test'
                script {
                    def testResults = findFiles(glob: '**/surefire-reports/*.xml')
                    for(xml in testResults) {
                        touch xml.getPath()
                    }
                }
            }
            post {
                always {
                    junit '**/surefire-reports/*.xml'
                    jacoco(
                            execPattern: 'target/*.exec',
                            classPattern: 'target/classes',
                            sourcePattern: 'src/main/java',
                            exclusionPattern: 'src/test*'
                    )
                }
            }
        }
        stage('Sonar') {
            environment {
                scannerHome = tool 'SonarQubeScanner'
            }
            steps {
                withSonarQubeEnv('my-sonar') {
                    sh "${scannerHome}/bin/sonar-scanner"
                    sleep(2)
                }
                timeout(time: 1, unit: 'MINUTES') {
                    waitForQualityGate abortPipeline: true
                }
            }
        }


        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean install'
            }
        }

        stage("Deploy to nexus") {
            steps {
                script {
                    pom = readMavenPom file: "pom.xml";
                    filesByGlob = findFiles(glob: "target/*.${pom.packaging}");
                    // Print some info from the artifact found
                    echo "${filesByGlob[0].name} ${filesByGlob[0].path} ${filesByGlob[0].directory} ${filesByGlob[0].length} ${filesByGlob[0].lastModified}"
                    // Extract the path from the File found
                    artifactPath = filesByGlob[0].path;
                    // Assign to a boolean response verifying If the artifact name exists
                    artifactExists = fileExists artifactPath;

                    if (artifactExists) {
                        echo "*** File: ${artifactPath}, group: ${pom.groupId}, packaging: ${pom.packaging}, version ${pom.version}";
                        nexusArtifactUploader(
                                nexusVersion: NEXUS_VERSION,
                                protocol: NEXUS_PROTOCOL,
                                nexusUrl: NEXUS_URL,
                                groupId: pom.groupId,
                                version: pom.version,
                                repository: NEXUS_REPOSITORY,
                                credentialsId: NEXUS_CREDENTIAL_ID,
                                artifacts: [
                                        // Artifact generated such as .jar, .ear and .war files.
                                        [artifactId: pom.artifactId,
                                         classifier: '',
                                         file      : artifactPath,
                                         type      : pom.packaging],
                                        // Lets upload the pom.xml file for additional information for Transitive dependencies
                                        [artifactId: pom.artifactId,
                                         classifier: '',
                                         file      : "pom.xml",
                                         type      : "pom"]
                                ]
                        );
                    }
                }
            }

        }
    }
}
