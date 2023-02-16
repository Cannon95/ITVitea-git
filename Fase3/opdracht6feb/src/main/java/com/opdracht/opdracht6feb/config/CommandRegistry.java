package com.opdracht.opdracht6feb.config;


import discord4j.common.JacksonResources;
import discord4j.discordjson.json.ApplicationCommandRequest;
import discord4j.rest.RestClient;
import discord4j.rest.service.ApplicationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CommandRegistry {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    private final RestClient restClient;
    private static final String commandsFolderName = "commands/";

    public CommandRegistry(RestClient restClient) {
        this.restClient = restClient;
    }

    protected void registerCommands() throws IOException {
        final JacksonResources d4jMapper = JacksonResources.create();
        final ApplicationService applicationService = restClient.getApplicationService();
        final long applicationID =  restClient.getApplicationId().block();
        List<ApplicationCommandRequest> commands = new ArrayList<>();
        File folder = new File("src/main/resources/commands");
        File[] listOfFiles = folder.listFiles();

        List<String> fileNames = new ArrayList<>();
        for(File file : listOfFiles){
            fileNames.add(file.getName());
        }

        for (String json : getCommandsJson(fileNames)) {
            ApplicationCommandRequest request = d4jMapper.getObjectMapper()
                    .readValue(json, ApplicationCommandRequest.class);

            commands.add(request); //Add to our array list
        }
        applicationService.bulkOverwriteGlobalApplicationCommand(applicationID, commands)
                .doOnNext(cmd -> {
                    LOGGER.debug("Successfully registered Global Command " + cmd.name());
                    System.out.println("Successfully registered Global Command " + cmd.name());
                })
                .doOnError(e -> {
                    LOGGER.error("Failed to register global commands", e);
                    System.out.println("Failed to register global commands" + e);
                })
                .subscribe();
    }

    private static List<String> getCommandsJson(List<String> fileNames) throws IOException {
        // Confirm that the commands folder exists
        URL url = CommandRegistry.class.getClassLoader().getResource(commandsFolderName);
        System.out.println("Path: " + url.getPath());
        Objects.requireNonNull(url, commandsFolderName + " could not be found");

        //Get all the files inside this folder and return the contents of the files as a list of strings
        List<String> list = new ArrayList<>();
        for (String file : fileNames) {
            String resourceFileAsString = getResourceFileAsString(commandsFolderName + file);
            list.add(Objects.requireNonNull(resourceFileAsString, "Command file not found: " + file));
        }
        return list;
    }

    private static String getResourceFileAsString(String fileName) throws IOException {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        try (InputStream resourceAsStream = classLoader.getResourceAsStream(fileName)) {
            if (resourceAsStream == null) return null;
            try (InputStreamReader inputStreamReader = new InputStreamReader(resourceAsStream);
                 BufferedReader reader = new BufferedReader(inputStreamReader)) {
                return reader.lines().collect(Collectors.joining(System.lineSeparator()));
            }
        }
    }

}
