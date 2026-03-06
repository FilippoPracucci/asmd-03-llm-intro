package e1.prompt;

import e1.model.Player;

public record BeginPrompt(Player player, String setting) implements StoryPrompt {
    private static final String TEMPLATE = """
            You are the narrator of an text-adventure game, so you have to ask the player question then he/she will make
            a choice.
            You have to start a new story considering the player stats and settings.
            The player called %s has %d level of health and %d of attack power.
            The setting description represents the context of the story and is: %s.
            Respond with ONLY a JSON object: { "narrative": String, "question": String, "choices": [String],
            "updatedPlayer": { "name": String, "health": Number, "attack": Number }, "gameOver": Boolean }.
            No explanation.
            """;

    @Override
    public String toPromptString() {
        return String.format(TEMPLATE,
                player.name(),
                player.health(),
                player.attackPower(),
                setting
        );
    }
}
