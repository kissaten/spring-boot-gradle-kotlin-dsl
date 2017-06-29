allprojects {

  group = "com.example"
  version = "0.0.1-SNAPSHOT"

  repositories {
    mavenCentral()
    maven { setUrl("https://repo.spring.io/milestone") }
  }

}

buildscript {
	ext {
		springBootVersion = '1.4.0.RELEASE'
	}
	repositories {
		mavenCentral()
	}
	dependencies {
		classpath("org.springframework.boot:spring-boot-gradle-plugin:${springBootVersion}")
	}
}

apply {
  plugin("spring-boot")
  plugin("java")
  plugin("idea")
  plugin("eclipse")
}

tasks.withType<Jar> {
  baseName = "heroku-demo"
}

configure<JavaPluginConvention> {
  setSourceCompatibility(1.8)
  setTargetCompatibility(1.8)
}

dependencies {
	compile('org.springframework.boot:spring-boot-starter-web')
	testCompile('org.springframework.boot:spring-boot-starter-test')
}
