#!/bin/bash

kubectl create secret docker-registry ghcr \
        --namespace=dev \
        --docker-username=fenrur \
        --docker-password="$GHCR_TOKEN" \
        --docker-server=ghcr.io