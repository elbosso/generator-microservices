FROM maven:3.6.1-jdk-11
RUN apt-get update && apt-get -y upgrade \
&& apt-get -y install git \
&& git clone https://github.com/elbosso/generator-microservices.git
WORKDIR generator-microservices
EXPOSE 7000
ENTRYPOINT ["/bin/bash", "./run.sh"]




