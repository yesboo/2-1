##ビルドステージ
#FROM maven:3.9-eclipse-temurin-21 AS builder
#WORKDIR /app
#COPY pom.xml .
#RUN mvn dependency:go-offline -q
#COPY src ./src
#RUN mvn package -DskipTests -q

##実行ステージ
#FROM quay.io/wildfly/wildfly:latest

##WARをデプロイディレクトリにコピー
#COPY --from=builder /app/target/*.war /opt/jboss/wildfly/standalone/deployments/

##デバッグ用にサスペンドなしで起動
#CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0", "--debug", "5005"]

# ビルドステージ
FROM maven:3.9-eclipse-temurin-21 AS builder
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline -q
COPY src ./src
RUN mvn package -DskipTests -q

# 実行ステージ
FROM quay.io/wildfly/wildfly:latest

COPY --from=builder /app/target/*.war /opt/jboss/wildfly/standalone/deployments/

# address=*:5005 で全インターフェースにバインド
ENV JAVA_OPTS="-agentlib:jdwp=transport=dt_socket,address=*:5005,server=y,suspend=n -Xms64m -Xmx512m -Djava.net.preferIPv4Stack=true -Djboss.modules.system.pkgs=org.jboss.byteman -Djava.awt.headless=true"

CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]
