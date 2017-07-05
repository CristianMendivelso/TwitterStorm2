package com.autentia.tutoriales;

import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.StormSubmitter;
import org.apache.storm.generated.AlreadyAliveException;
import org.apache.storm.generated.InvalidTopologyException;
import org.apache.storm.topology.TopologyBuilder;
import org.apache.storm.tuple.Fields;

import com.autentia.tutoriales.bolt.CountPrinterBolt;
import com.autentia.tutoriales.bolt.TweetSplitterBolt;
import com.autentia.tutoriales.bolt.WordCounterBolt;
import com.autentia.tutoriales.spout.TweetsStreamingConsumerSpout;
import org.apache.storm.generated.AuthorizationException;

public class WordCountTopology {

	public static void main(String... args) throws AlreadyAliveException, InvalidTopologyException, AuthorizationException {
		final TopologyBuilder builder = new TopologyBuilder();
		builder.setSpout("twitterSpout", new TweetsStreamingConsumerSpout());
		builder.setBolt("tweetSplitterBolt", new TweetSplitterBolt(), 10).shuffleGrouping("twitterSpout");
		builder.setBolt("wordCounterBolt", new WordCounterBolt(), 10).fieldsGrouping("tweetSplitterBolt", new Fields("word"));
		builder.setBolt("countPrinterBolt", new CountPrinterBolt(), 10).fieldsGrouping("wordCounterBolt", new Fields("word"));

		final Config conf = new Config();
		//conf.setDebug(false);
                conf.setNumWorkers(3);
                StormSubmitter.submitTopology("words", conf, builder.createTopology());

		//final LocalCluster cluster = new LocalCluster();
		//cluster.submitTopology("wordCountTopology", conf, builder.createTopology());
	}
}

