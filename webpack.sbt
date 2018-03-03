import scala.sys.process.Process

lazy val npm = taskKey[Unit]("Run NPM when packaging the application")

def npmInstall(file: File) = Process("npm install", file) !
def runWebpack(file: File) = Process("npm run build", file) !

def runJS(file: File): Int = {
  npmInstall(file)
  runWebpack(file)
}

npm := {
  val result = runJS(baseDirectory.value)
  if(result != 0) throw new Exception("Something went wrong when running webpack.")
}

dist := (dist dependsOn npm).value

stage := (stage dependsOn npm).value

