package ch.ralscha.springplayground.taffy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

	@Autowired
	private Twitter twitter;

	@RequestMapping("/getPublicTimeline")
	@ResponseBody
	public List<Tweet> returnSomeTweets() {
		return twitter.timelineOperations().getPublicTimeline();
	}
}