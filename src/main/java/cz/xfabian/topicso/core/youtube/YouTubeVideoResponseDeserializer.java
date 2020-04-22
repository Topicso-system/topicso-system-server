//package cz.xfabian.topicso.core.youtube;
//
//import com.fasterxml.jackson.core.JsonParser;
//import com.fasterxml.jackson.databind.DeserializationContext;
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
//import com.fasterxml.jackson.databind.node.ArrayNode;
//
//import java.io.IOException;
//
//public class YouTubeVideoResponseDeserializer extends StdDeserializer<VideoDetails> {
//
//    public YouTubeVideoResponseDeserializer(Class<?> vc) {
//        super(vc);
//    }
//
//    @Override
//    public VideoDetails deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
//        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
//        ArrayNode items = (ArrayNode) node.get("items");
//        JsonNode snippet = items.get("snippet");
//
//        VideoDetails videoDetails = new VideoDetails();
//        videoDetails.setYoutubeId(items.get("id").asText());
//        videoDetails.setTitle(snippet.get("title").asText());
//        videoDetails.setDescription(snippet.get("description").asText());
//
//        return videoDetails;
//    }
//}
