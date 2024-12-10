const { writeFile, readFile } = require('fs').promises;

async function prepare(pluginConfig, context) {
    const { nextRelease: { version }, logger } = context;

    await writeFile('./VERSION', version, 'utf8');

    const contentGradleProperties = await readFile('./kars-backend/gradle.properties', 'utf8')
    const newContentGradleProperties = contentGradleProperties.replace(/projectVersion=.*/, `projectVersion=${version}`);
    await writeFile('./kars-backend/gradle.properties', newContentGradleProperties, 'utf8');
    
    const contentPackageJson = await readFile('./kars-frontend/package.json', 'utf8')
    const newContentPackageJson = contentPackageJson.replace(/"version": ".*/, `"version": "${version}",`);
    await writeFile('./kars-frontend/package.json', newContentPackageJson, 'utf8');
}

module.exports = { prepare };
