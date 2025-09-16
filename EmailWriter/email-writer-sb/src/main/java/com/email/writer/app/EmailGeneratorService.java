package com.email.writer.app;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class EmailGeneratorService {

    private final WebClient webClient;

    public EmailGeneratorService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }

    @Value("${gemini.api.url}")
    private String geminiApiUrl;

    @Value("${gemini.api.key}")
    private String geminiApiKey;

    public String generateEmailReply(EmailRequest emailRequest) {
        // Build the promt
        String prompt = buildPrompt(emailRequest);

        // Craft the API request to OpenAI
        Map<String, Object> requestBody = Map.of(
            "contents", new Object[] {
                Map.of("parts", new Object[]{
                    Map.of("text", prompt)
                })
            }
        );

        // Make the API call (using a hypothetical HttpClient)
        String response = webClient.post()
            .uri(geminiApiUrl + "?key=" + geminiApiKey)
            // .header("Content-Type", "application/json; charset=UTF-8")
            .bodyValue(requestBody)
            .retrieve()
            .bodyToMono(String.class)
            .block();

        // Extract and return the generated email from the response
        return extractResponseContent(response);
    }

    private String extractResponseContent(String response) {
        try{
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(response);
            return root.path("candidates").get(0).path("content").path("parts").get(0).path("text").asText();
        }
        catch(Exception e){
            return "Error processing response: " + e.getMessage();
        }
        
    }

    private String buildPrompt(EmailRequest emailRequest) {
        StringBuilder prompt = new StringBuilder();
        prompt.append("Generate a reply email with the following content (don't generate the subject line): ");
        prompt.append("\n");
        if(emailRequest.getTone() != null && !emailRequest.getTone().isEmpty()) {
            prompt.append(" use a ").append(emailRequest.getTone()).append(" tone.");
        }
        prompt.append("\nOriginal Email content: \n").append(emailRequest.getEmailContent());
        return prompt.toString();
    }
}
