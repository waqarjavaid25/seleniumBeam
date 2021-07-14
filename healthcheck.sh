#!/usr/bin/env bash
# Environment Variables
# SELENIUM_HUB
# BROWSER
# MODULE

echo "Checking if hub is ready - $SELENIUM_HUB"
echo "$ENV_VAR"

while [ "$( curl -s http://$SELENIUM_HUB:4444/wd/hub/status | jq -r .value.ready )" != "true" ]
do
  echo "hub is not ready at $SELENIUM_HUB"
	sleep 1
done
  echo "hub is now ready at $SELENIUM_HUB"

# start the java command
java -cp selenium-docker.jar:selenium-docker-tests.jar:libs/* \
    -DSELENIUM_HUB=$SELENIUM_HUB \
    -DBROWSER=$BROWSER \
    -DTARGET_WEBDRIVER=$TARGET_WEBDRIVER \
    org.testng.TestNG $MODULE

