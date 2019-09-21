#!/bin/bash
gradle test && git commit -am working || git reset --hard