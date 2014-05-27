package pl.put.idss.dw.hadoop.tasks;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

public class MVMultTask {

	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();
		String[] otherArgs = new GenericOptionsParser(conf, args)
				.getRemainingArgs();
		if (otherArgs.length != 3) {
			System.err.println("Usage: mv-mult <input_dir> <output_dir> <vector>");
			System.exit(2);
		}

		Job job = new Job(conf, "matrix-vector-mult");
		job.setJarByClass(MVMultTask.class);

		// job.setMapperClass( /* TODO */ );
		// job.setReducerClass(/* TODO */ );

		FileInputFormat.addInputPath(job, new Path(otherArgs[0] + "/M.txt"));
		FileOutputFormat.setOutputPath(job, new Path(otherArgs[1]));

		if (job.waitForCompletion(true)) {
			System.exit(0);
		}
		System.exit(1);

	}

}
