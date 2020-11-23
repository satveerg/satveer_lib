pipeline {
   agent { label 'master' }
   stages {
       stage('write') {
           steps {
               script {
                   def filecontent=libraryResource "Routes.yaml"
	                def pipelineRulesList = yaml.load(filecontent)
                   
               }
           }
       }
   }
}
