FROM mcr.microsoft.com/devcontainers/java:dev-17-jdk-bookworm
ARG GRADLE_VERSION="7.3"
RUN su vscode -c "umask 0002 && . /usr/local/sdkman/bin/sdkman-init.sh && sdk install gradle \"${GRADLE_VERSION}\""