#!/bin/bash
source /etc/profile
cd `dirname $0`
./stop.sh
./start.sh
