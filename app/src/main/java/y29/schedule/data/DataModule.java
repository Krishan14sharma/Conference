package y29.schedule.data;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import y29.schedule.data.remote.Repository;

/**
 * Created by krishan on 4/2/16.
 */
@Module
public class DataModule {

    @Provides
    @Singleton
    Repository provideRestRepository() {
        return null;
    }

    /*@Provides
    @Singleton
    Retrofit provideRetrofit(Application application) {
        return new Retrofit.Builder()
                .baseUrl(PRODUCTION_API_URL)
                .client(createOkHttpClient(application, encryptor, manager))
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }*/

    /*static OkHttpClient createOkHttpClient(Application app, Encryptor encryptor, PrefManager manager) {
        // Install an HTTP cache in the application cache directory.
//        File cacheDir = new File(app.getCacheDir(), "http");
//        Cache cache = new Cache(cacheDir, DISK_CACHE_SIZE);
        final OkHttpClient okHttpClient = new OkHttpClient();
        //add interceptor for the automatic logging of request and response from api
        okHttpClient.interceptors().add(new SecurityInterceptor(encryptor, manager));
        if (BuildConfig.LOG_HTTP_REQUESTS) {
            final HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            okHttpClient.interceptors().add(interceptor);
            okHttpClient.interceptors().add(new CurlLoggingInterceptor());
        }
        //add the profile time interceptor
        return okHttpClient;
    }*/

}
