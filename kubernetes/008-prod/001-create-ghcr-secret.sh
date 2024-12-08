#!/bin/bash

kubectl create secret docker-registry ghcr \
        --namespace=prod \
        --docker-username=fenrur \
        --docker-password="$GHCR_TOKEN" \
        --docker-server=ghcr.io