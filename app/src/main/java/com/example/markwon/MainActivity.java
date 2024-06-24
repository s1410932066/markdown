package com.example.markwon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Spanned;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import org.commonmark.node.Node;

import io.noties.markwon.AbstractMarkwonPlugin;
import io.noties.markwon.Markwon;
import io.noties.markwon.SoftBreakAddsNewLinePlugin;
import io.noties.markwon.core.MarkwonTheme;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        scrollView = findViewById(R.id.scrollView);
        // obtain an instance of Markwon
        final Markwon markwon = Markwon.builder(this)
                .usePlugin(SoftBreakAddsNewLinePlugin.create())
                .build();
        final Spanned markdown = markwon.toMarkdown("## 仁寶Markdwon測試\n" +
                "### Route planning to Elephant Mountain\n" +
                "2024/04/07\n" +
                "\n" +
                "You:\n" +
                "Plan a route to elephant mountain\n" +
                "\n" +
                "Response:\n" +
                "Sure! Taipei has many great spots to visit. Here are some recommendations:\n" +
                "1. Taipei 101: Visit one of the tallest buildings in the world and enjoy panoramic views of Taipei from the observatory.\n" +
                "2. National Palace Museum: Explore a vast collection of ancient Chinese artifacts, including jade, ceramics, and paintings.");
        // set markdown
        markwon.setParsedMarkdown(textView, markdown);
    }
}