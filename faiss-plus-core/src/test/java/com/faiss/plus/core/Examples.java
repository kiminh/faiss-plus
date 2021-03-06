package com.faiss.plus.core;

import junit.framework.Assert;

import java.nio.file.Paths;
import java.util.Random;
import static com.faiss.plus.util.IndexHelper.*;

public class Examples {

	public static void main(String[] args) {
		simpleTest();
//		testFlat();
		System.out.println("Hello World!");
	}

	public static void load() {
		System.load(Paths.get("./swigfaiss4j.so").toAbsolutePath().toString());
		System.loadLibrary("faiss");
	}

	public static void testFlat() {
		int d = 5; // dimension
		int nb = 10; // database size
		int nq = 10000; // nb of queries

//        float[] xb = new float[d * nb];
//        float[] xq = new float[d * nq];
		try {
			floatArray xb = new floatArray(d * nb);

			Random rand = new Random();

			for (int i = 0; i < nb; i++) {
				for (int j = 0; j < d; j++) {
//                xb[d * i + j] = rand.nextFloat();
					xb.setitem(d * i + j, rand.nextFloat());
				}
//            xb[d * i] += i / 1000.;
				xb.setitem(d * i, (float) (i / 1000.0));
			}

			IndexFlatL2 index = new IndexFlatL2(d);
			System.out.println("is_trained = "+ index.getIs_trained());
			index.add(nb, xb.cast());
			System.out.println("ntotal = "+ index.getNtotal());

//            long *I = new long[k * 5];
//            float *D = new float[k * 5];
			{
				int k = 4;
				longArray I = new longArray(k * 5);
				floatArray D = new floatArray(k * 5);

				System.out.println("search 5 first vector of xb");
				index.search(5, xb.cast(), 4, D.cast(), I.cast());
				System.out.println("Vectors:\n " + show(xb, nb, d));
				System.out.println("Distances:\n{}"+ show(D, 5, 4));
				System.out.println("I:\n{}"+ show(I, 5, 4));
			}
		} catch (Exception e) {
			System.out.println("failed" + e.getMessage());
		}
	}

	public static void simpleTest() {
		try {
			float[][] data = dummyData3d(10);
			int d = data[0].length;
			int numberOfVector = data.length;
			floatArray xb = makeFloatArray(data);
			longArray ids = makeLongArray(new int[] { 0, 1, 2 });
			IndexFlatL2 index = new IndexFlatL2(d);
			// what(): Error in virtual void faiss::Index::add_with_ids(faiss::Index::idx_t,
			// const float*, const long int*) at Index.cpp:46: add_with_ids not implemented
			// for this type of index

//            index.add_with_ids(3, xb.cast(), ids.cast());
			index.add(numberOfVector, xb.cast());

			System.out.println("ntotal = {}"+ index.getNtotal());

			{
				int resultSize = 3;
				float[][] queryConds = { new float[] { 0, 1, 8 } };

				floatArray query = makeFloatArray(queryConds);
				longArray labels = new longArray(resultSize);
				floatArray distances = new floatArray(resultSize);
				index.search(1, query.cast(), resultSize, distances.cast(), labels.cast());

				System.out.println("Vectors:\n{}"+ show(xb, numberOfVector, d));
				System.out.println("Query:\n{}"+ show(query, queryConds.length, queryConds[0].length));
				System.out.println("Distances:\n{}"+ show(distances, 1, resultSize));
				System.out.println("Labels:\n{}"+ show(labels, 1, resultSize));
			}
		} catch (Exception e) {
			System.out.println("failed"+ e.getMessage());
		}
	}

	public void testSearchRange() {
		float[][] data = dummyData3d(20);
		int d = data[0].length;
		int numberOfVector = data.length;

		try {
			floatArray xb = makeFloatArray(data);
			IndexFlatL2 index = new IndexFlatL2(d);
			index.add(numberOfVector, xb.cast());

			{
				int resultSize = 4;
				float[][] queryConds = { new float[] { 0, 1, 8 } };
				floatArray query = makeFloatArray(queryConds);

				RangeSearchResult re = new RangeSearchResult(resultSize);
				int querySize = queryConds.length;
				index.range_search(querySize, query.cast(), 0.3f, re);

				longArray labels = longArray.frompointer(re.getLabels());
				floatArray distances = floatArray.frompointer(re.getDistances());

				System.out.println("Vectors:\n{}"+ show(xb, numberOfVector, d));
				System.out.println("Query:\n{}"+ show(query, querySize, queryConds[0].length));
				System.out.println("Distances:\n{}"+ show(distances, querySize, resultSize));
				System.out.println("Labels:\n{}"+ show(labels, querySize, resultSize));
			}

		} catch (Exception e) {
			System.out.println("failed"+e.getMessage());
		}
	}

	public void egIndexIVFFlat() {
		try {
			float[][] data = randomData3d(200);
			int dimension = data[0].length;
			int numberOfVector = data.length;
			int nlist = 6;
			int nprobe = 2;

			IndexFlatL2 quantizer = new IndexFlatL2(dimension);
			IndexIVFFlat index = new IndexIVFFlat(quantizer, dimension, nlist, MetricType.METRIC_L2);

			Assert.assertTrue(!index.getIs_trained());
			float[][] trainData = dummyData3d(5);
			floatArray tb = makeFloatArray(trainData);
			System.out.println("Vectors:\n{}"+ show(tb, trainData.length, dimension));
			index.train(trainData.length, tb.cast());
			Assert.assertTrue(index.getIs_trained());

			floatArray xb = makeFloatArray(data);
			index.add(numberOfVector, xb.cast());

			int resultSize = 10;
			float[][] queryConds = { new float[] { 0, 0, 8 } };

			floatArray query = makeFloatArray(queryConds);
			longArray labels = new longArray(resultSize);
			floatArray distances = new floatArray(resultSize);

			int numberOfQuery = queryConds.length;
			index.setNprobe(nprobe);
			index.search(numberOfQuery, query.cast(), resultSize, distances.cast(), labels.cast());

			System.out.println("Vectors:\n{}"+ show(xb, numberOfVector, dimension));
			System.out.println("Query:\n{}"+ show(query, queryConds.length, queryConds[0].length));
			System.out.println("Distances:\n{}"+ show(distances, 1, resultSize));
			System.out.println("Labels:\n{}"+ show(labels, 1, resultSize));
		} catch (Exception e) {
			System.out.println("failed"+e.getMessage());
		}
	}

	private static float[][] dummyData3d(int size) {
		float[][] data = new float[size * 3][3];
		float half = size / 2.0f;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < size; j++) {
				float[] row = new float[] { 0, 0, 0 };
				row[i] = j - half;
				data[i * size + j] = row;
			}
		}
		return data;
	}

	private static float[][] randomData3d(int size) {
		float[][] data = new float[size * 3][3];
		float half = size / 2.0f;
		Random rand = new Random();
		for (int i = 0, j = data.length; i < j; i++) {
			float[] row = new float[] { rand.nextFloat() * size, rand.nextFloat() * size, rand.nextFloat() * size };
			data[i] = row;
		}
		return data;
	}

}
