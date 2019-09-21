#!/bin/bash
mvn test && git commit -am working || git reset --hard