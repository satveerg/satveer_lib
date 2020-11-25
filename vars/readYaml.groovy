#!/usr/local/bin/groovy
import org.yaml.snakeyaml.Yaml
def call() {
	def yaml = new Yaml()
	println("YAML object to read pipeline rules has been created")
    def filecontent=libraryResource "com/marriott/platform/Routes.yml"
	  def pipelineRulesList = yaml.load(filecontent)
	println "Pipeline rules file loaded - " +pipelineRulesList
}
