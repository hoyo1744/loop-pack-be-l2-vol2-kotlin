plugins {
    id("org.jetbrains.kotlin.plugin.jpa")
    `java-test-fixtures`
}

dependencies {
    // jpa
    api("org.springframework.boot:spring-boot-starter-data-jpa")
    // querydsl
    api("com.querydsl:querydsl-jpa::jakarta")
    kapt("com.querydsl:querydsl-apt::jakarta")
    // kotlin-jdsl
    api("com.linecorp.kotlin-jdsl:jpql-dsl:3.8.0")
    api("com.linecorp.kotlin-jdsl:jpql-render:3.8.0")
    api("com.linecorp.kotlin-jdsl:spring-data-jpa-support:3.8.0")
    // jdbc-mysql
    runtimeOnly("com.mysql:mysql-connector-j")

    testImplementation("org.testcontainers:mysql")

    testFixturesImplementation("org.springframework.boot:spring-boot-starter-data-jpa")
    testFixturesImplementation("org.testcontainers:mysql")
}
