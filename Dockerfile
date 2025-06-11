FROM tomcat:latest
ADD target/*.war /usr/local/tomcat/webapps/
EXPOSE 9090
ENV JAVA_OPTS="-Dorg.jenkinsci.plugins.durabletask.BourneShellScript.HEARTBEAT_CHECK_INTERVAL=86400"
CMD ["catalina.sh", "run"]
